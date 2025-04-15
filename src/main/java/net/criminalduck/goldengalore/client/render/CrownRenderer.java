package net.criminalduck.goldengalore.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

@OnlyIn(Dist.CLIENT)
public class CrownRenderer implements ICurioRenderer {

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack itemStack, SlotContext slotContext, PoseStack poseStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource multiBufferSource, int light, float v, float v1, float v2, float v3, float v4, float v5) {
        LivingEntity wearer = slotContext.entity();

        EntityRenderer<? super LivingEntity> renderer = Minecraft.getInstance()
                .getEntityRenderDispatcher()
                .getRenderer(wearer);

        if (renderer instanceof LivingEntityRenderer<?, ?> livingRenderer
                && livingRenderer.getModel() instanceof HumanoidModel<?> model) {

            poseStack.pushPose();
            model.head.translateAndRotate(poseStack);

            if (wearer.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
                poseStack.scale(0.9f, 0.9f, 0.9f);
            }

            Minecraft.getInstance().getItemRenderer().renderStatic(
                    itemStack, ItemDisplayContext.HEAD, light, OverlayTexture.NO_OVERLAY,
                    poseStack, multiBufferSource, wearer.level(), 0
            );

            poseStack.popPose();
        }
    }
}
